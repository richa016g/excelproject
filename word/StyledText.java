import java.awt.Color;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import org.apache.poi.xwpf.usermodel.*;


public class StyledText {
    public static void main(String[] args) throws Exception {
        // prepare
        JTextPane pad = new JTextPane();
        pad.setContentType("text/html");
        HTMLEditorKit kit = (HTMLEditorKit)pad.getEditorKit();
        HTMLDocument htmldoc = (HTMLDocument)kit.createDefaultDocument();
        kit.insertHTML(htmldoc, htmldoc.getLength(), "<p>paragraph <b>1</b></p>", 0, 0, null);
        kit.insertHTML(htmldoc, htmldoc.getLength(), "<p>paragraph <span style=\"color:red\">2</span></p>", 0, 0, null);
        pad.setDocument(htmldoc);

        // convert
        StyledDocument doc = pad.getStyledDocument();
        XWPFDocument docX = new XWPFDocument();

        int lastPos=-1; 
        while (lastPos < doc.getLength()) {
            Element line = doc.getParagraphElement(lastPos+1);
            lastPos = line.getEndOffset();
            XWPFParagraph paragraph = docX.createParagraph();
            for (int elIdx=0; elIdx < line.getElementCount(); elIdx++) {
                final Element frag = line.getElement(elIdx);

                XWPFRun run = paragraph.createRun();
                String subtext = doc.getText(frag.getStartOffset(), frag.getEndOffset()-frag.getStartOffset());
                run.setText(subtext);

                final AttributeSet as = frag.getAttributes();
                final Enumeration<?> ae = as.getAttributeNames();

                while (ae.hasMoreElements()) {
                    final Object attrib = ae.nextElement();

                    if (CSS.Attribute.COLOR.equals(attrib)) {
                        // I don't know how to really work with the CSS-swing class ...
                        Field f = as.getAttribute(attrib).getClass().getDeclaredField("c");
                        f.setAccessible(true);
                        Color c = (Color)f.get(as.getAttribute(attrib));
                        run.setColor(String.format("%1$02X%2$02X%3$02X", c.getRed(),c.getGreen(),c.getBlue()));
                    } else if (CSS.Attribute.FONT_WEIGHT.equals(attrib)) {
                        if ("bold".equals(as.getAttribute(attrib).toString())) {
                            run.setBold(true);
                        }
                    }
                }               
            }
        }

        FileOutputStream fos = new FileOutputStream("test.docx"); 
        docX.write(fos);
        fos.close();
    }
}