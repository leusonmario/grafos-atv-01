import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GrafoTest {

  @Test
  public void expectTrueForAddingNewVertice(){
    Grafo grafo = new Grafo();
    Vertice vertice = new Vertice("1");
    Assert.assertTrue(grafo.addNewVertice(vertice));
  }

  @Test
  public void expectFalseForAddingNewVertice(){
    Grafo grafo = new Grafo();
    Vertice vertice = new Vertice("1");
    grafo.addNewVertice(vertice);
    Assert.assertFalse(grafo.addNewVertice(vertice));
  }

  @Test
  public void expectTrueForNewAresta(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);
    Assert.assertTrue(grafo.addNewAresta(vertice1, vertice2));
  }

  @Test
  public void expectFalseForNewAresta(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    Assert.assertFalse(grafo.addNewAresta(vertice1, vertice2));
  }

  @Test
  public void expectFalseForLoop(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);
    Assert.assertFalse(grafo.addNewAresta(vertice1, vertice1));
  }

  @Test
  public void expectFalseForMultipleAresta(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);
    grafo.addNewAresta(vertice1, vertice2);
    Assert.assertFalse(grafo.addNewAresta(vertice1, vertice2));
  }

  @Test
  public void expectSameSizeOfGraph(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);

    Vertice vertice3 = new Vertice("3");
    Vertice vertice4 = new Vertice("4");
    grafo.addNewVertice(vertice3);
    grafo.addNewVertice(vertice4);

    Assert.assertEquals(4, grafo.getSize());
  }

  @Test
  public void expectSameSizeOfEdgesGraph(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);

    Vertice vertice3 = new Vertice("3");
    Vertice vertice4 = new Vertice("4");
    grafo.addNewVertice(vertice3);
    grafo.addNewVertice(vertice4);

    grafo.addNewAresta(vertice1, vertice2);
    grafo.addNewAresta(vertice2, vertice3);
    grafo.addNewAresta(vertice3, vertice4);
    grafo.addNewAresta(vertice4, vertice1);

    Assert.assertEquals(4, grafo.getEdgesLenght());
  }

  @Test
  public void expectThreeEdgesOnNode(){
    Grafo grafo = new Grafo();
    Vertice vertice1 = new Vertice("1");
    Vertice vertice2 = new Vertice("2");
    Vertice vertice3 = new Vertice("3");
    Vertice vertice4 = new Vertice("4");

    grafo.addNewVertice(vertice1);
    grafo.addNewVertice(vertice2);
    grafo.addNewVertice(vertice3);
    grafo.addNewVertice(vertice4);

    grafo.addNewAresta(vertice1, vertice2);
    grafo.addNewAresta(vertice1, vertice3);
    grafo.addNewAresta(vertice1, vertice4);

    Assert.assertEquals(3, grafo.getNumberOfEdgesByNodeId("1"));
  }

}
