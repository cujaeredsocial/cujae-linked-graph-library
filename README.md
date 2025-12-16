# Cujae Linked Graph Library

![CUJAE](https://img.shields.io/badge/CUJAE-University-blue?style=for-the-badge&logo=graduation-cap)
![Java 8](https://img.shields.io/badge/Java->=8-orange?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Apache%20Maven-3.8.7-red?style=for-the-badge&logo=apache-maven)

Librería para el trabajo con estructuras de grafos del CEIS (Cujae) para estudiantes de Ingeniería Informática en la asignatura Estructura de Datos.

## Cómo me instalo esto?

Esta librería está disponible como archivo JAR en [la sección de Releases](https://github.com/cujaeredsocial/cujae-linked-graph-library/releases). Para utilizarla en tu proyecto:

1. Descarga el archivo `.jar` de la última release
2. Importa el JAR en tu proyecto:
   - **En Eclipse**: Click derecho en el proyecto → Build Path → Configure Build Path → Libraries → Add External JARs
   - **En IntelliJ**: File → Project Structure → Modules → Dependencies → + → JARs or directories
   - **En NetBeans**: Click derecho en el proyecto → Properties → Libraries → Add JAR/Folder

## Estructura del Proyecto

La librería contiene implementaciones de grafos con diferentes características:
- Grafos dirigidos y no dirigidos
- Grafos con vértices ponderados
- Grafos con aristas ponderadas
- Implementación basada en listas enlazadas

## Paquete
```java
import cu.edu.cujae.ceis.graph;
```

> Especificación de Javadocs se encuentra en: 
> https://cujaeredsocial.github.io/cujae-linked-graph-library/javadoc/

## Una vista rápida a la librería 

### Clases Principales

#### `Graph.java` (Clase Abstracta)
```java
public abstract class Graph {
    public abstract boolean isEmpty();
}
```

#### `LinkedGraph.java` (Implementación Principal y la única)
Implementa múltiples interfaces para soportar diferentes tipos de grafos:

```java
public class LinkedGraph extends Graph implements 
    ILinkedDirectedGraph, 
    ILinkedNotDirectedGraph,
    ILinkedWeightedEdgeDirectedGraph, 
    ILinkedWeightedEdgeNotDirectedGraph,
    ILinkedWeightedVertexDirectedGraph, 
    ILinkedWeightedVertexNotDirectedGraph {
    
    // Constructor
    public LinkedGraph()
    
    // Métodos comunes a todos los grafos
    public boolean isEmpty()
    public int getVertexIndex(Vertex vertex)
    public boolean areAdjacents(int posTail, int posHead)
    public boolean insertVertex(Object info)
    public boolean pathWithLength(int posTail, int posHead, int length)
    public LinkedList<Vertex> getVerticesList()
    public LinkedList<Vertex> adjacentsG(int pos)
    public Vertex deleteVertex(int pos)
    public LinkedList<Vertex> deleteVertexCascade(int pos)
    
    // Métodos para grafos dirigidos
    public boolean cyclicDG()
    public int degreeDG(int pos)
    public int inDegreeDG(int pos)
    public int outDegree(int pos)
    public boolean deleteEdgeD(int posTail, int posHead)
    public boolean insertEdgeDG(int posTail, int posHead)
    public LinkedList<Vertex> removeDisconnectVerticesDG()
    
    // Métodos para grafos no dirigidos
    public boolean cyclicND()
    public int degreeND(int pos)
    public boolean deleteEdgeND(int posTail, int posHead)
    public boolean insertEdgeNDG(int posTail, int posHead)
    public LinkedList<Vertex> removeDisconnectVerticesND()
    
    // Métodos para grafos con aristas ponderadas
    public boolean insertWEdgeDG(int posTail, int posHead, Object weight)
    public boolean insertWEdgeNDG(int posTail, int posHead, Object weight)
    
    // Métodos para grafos con vértices ponderados
    public boolean insertWVertex(Object info, Object weight)
}
```

### Componentes de Grafos

#### 1. `Vertex.java` (Vértice Elemental)
```java
public class Vertex {
    public Vertex(Object info)
    public boolean deleteEdge(Vertex vertex)
    public LinkedList<Edge> getEdgeList()
    public Object getInfo()
    public void setInfo(Object info)
    public LinkedList<Vertex> getAdjacents()
    public boolean isAdjacent(Vertex vertex)
    public String toString()
}
```

#### 2. `WeightedVertex.java` (Vértice con Peso)
```java
public class WeightedVertex extends Vertex {
    public WeightedVertex(Object info, Object weight)
    public Object getWeight()
}
```

#### 3. `Edge.java` (Arista Elemental)
```java
public class Edge {
    public Edge(Vertex vertex)
    public Vertex getVertex()
    public void setVertex(Vertex vertex)
}
```

#### 4. `WeightedEdge.java` (Arista con Peso)
```java
public class WeightedEdge extends Edge {
    public WeightedEdge(Vertex vertex, Object weight)
    public Object getWeight()
}
```

### Interfaces

La librería utiliza un sistema de interfaces para definir capacidades específicas:

- **`ILinkedDirectedGraph`**: Operaciones para grafos dirigidos
- **`ILinkedNotDirectedGraph`**: Operaciones para grafos no dirigidos
- **`ILinkedWeightedEdgeDirectedGraph`**: Grafos dirigidos con aristas ponderadas
- **`ILinkedWeightedEdgeNotDirectedGraph`**: Grafos no dirigidos con aristas ponderadas
- **`ILinkedWeightedVertexDirectedGraph`**: Grafos dirigidos con vértices ponderados
- **`ILinkedWeightedVertexNotDirectedGraph`**: Grafos no dirigidos con vértices ponderados

## Ejemplos de Uso

### Creación de un Grafo Dirigido
```java
LinkedGraph graph = new LinkedGraph();

// Insertar vértices
graph.insertVertex("A");
graph.insertVertex("B");
graph.insertVertex("C");

// Insertar aristas dirigidas
graph.insertEdgeDG(0, 1);  // A → B
graph.insertEdgeDG(1, 2);  // B → C
graph.insertEdgeDG(2, 0);  // C → A

// Verificar si hay ciclo
boolean hasCycle = graph.cyclicDG();  // true
```

### Creación de un Grafo No Dirigido con Ponderación
```java
LinkedGraph graph = new LinkedGraph();

// insertar vertices
graph.insertVertex("Ciudad A");
graph.insertVertex("Ciudad B");
graph.insertVertex("Ciudad C");

//insertar aristas ponderadas (distancias)
graph.insertWEdgeNDG(0, 1, 150);  // A ↔ B, distancia 150km
graph.insertWEdgeNDG(1, 2, 200);  // B ↔ C, distancia 200km
graph.insertWEdgeNDG(2, 0, 180);  // C ↔ A, distancia 180km
```

### Trabajo con Vértices Ponderados
```java
LinkedGraph graph = new LinkedGraph();

// Insertar vértices ponderados (ciudad con población)
graph.insertWVertex("La Habana", 2100000);
graph.insertWVertex("Santiago", 500000);
graph.insertWVertex("Camagüey", 300000);

// Crear conexiones
graph.insertEdgeNDG(0, 1);
graph.insertEdgeNDG(1, 2);
```

### Operaciones Avanzadas
```java
LinkedGraph graph = new LinkedGraph();
// ... inicializar grafo ...

// Eliminar vértice en cascada
LinkedList<Vertex> deleted = graph.deleteVertexCascade(0);

// Encontrar grado de un vértice
int degree = graph.degreeDG(2);  // Para grafo dirigido
// o
int degree = graph.degreeND(2);  // Para grafo no dirigido

// Verificar adyacencia
boolean adjacent = graph.areAdjacents(0, 1);

// Verificar existencia de camino de longitud específica
boolean hasPath = graph.pathWithLength(0, 2, 3);
```

> [!note]
> - Los vértices se almacenan en una `LinkedList<Vertex>`
> - Cada vértice mantiene su propia lista de aristas
> - Los índices de posición comienzan en 0
> - Los métodos devuelven `-1` o `null` en caso de error
> - Los pesos pueden ser cualquier tipo de objeto
