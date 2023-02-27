package start;
import java.io.InputStream;
import java.io.FileInputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;

public class TurtleToRDFConverter {
  public static void main(String[] args) {
    String inputFileName = "input.ttl";
    String outputFileName = "output.rdf";

    // Create an empty Jena model
    Model model = ModelFactory.createDefaultModel();

    try {
      // Read the Turtle file into an input stream
      InputStream in = new FileInputStream(inputFileName);

      // Use Jena's RDFDataMgr to parse the Turtle file and add its contents to the model
      RDFDataMgr.read(model, in, RDFFormat.TURTLE);

      // Iterate over the model's statements and print them to the console
      StmtIterator iter = model.listStatements();
      while (iter.hasNext()) {
        Statement stmt = iter.next();
        System.out.println(stmt);
      }

      // Write the model to an RDF file
      RDFDataMgr.write(System.out, model, RDFFormat.RDFXML);

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
