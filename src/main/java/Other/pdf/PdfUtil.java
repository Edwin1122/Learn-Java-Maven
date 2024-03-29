package Other.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

import java.io.File;
import java.io.IOException;

public class PdfUtil {

    public static void generatePdf() throws IOException {
        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage( page );

// Create a new font object by loading a TrueType font into the document
//        PDFont font = PDTrueTypeFont.load(document, "Arial.ttf");
        PDFont font = PDTrueTypeFont.load(document, new File("C:\\Windows\\Fonts\\simhei.ttf"), WinAnsiEncoding.INSTANCE);

// Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        //set text position
        contentStream.newLineAtOffset( 100, 700 );
//        contentStream.moveTextPositionByAmount( 100, 700 );
        contentStream.showText( "Hello World" );
        contentStream.endText();

// Make sure that the content stream is closed:
        contentStream.close();

// Save the results and ensure that the document is properly closed:
        document.save( "Hello World.pdf");
        document.close();
    }
}
