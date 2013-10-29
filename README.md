SemanticTranslator
==================

The semantic translator executes predefined ontology mapping to mediate differences between ontologies. 

![Translator](http://photo.yupoo.com/jjfd/DgX0BKpb/medish.jpg)

We generally use the Jena framework  to handle the semantic level operations, and the open-source Pellet reasoner  for reasoning, which is a complete OWL DL reasoner and can reason with SWRL rules, to implement the semantic translator. 

1. The translator is fed with serialized ontology instances. 
2. It parses the input using Jena Ontology API (OntModel type defined in Jena framework)
3. then loads ontology mapping from the knowledge base (the configuration parameter "mappingRef"). 
4. The data and mapping knowledge is passed to the Pellet reasoner to produce new facts, such as new classification of an instance in terms of the target ontology (InfModel in Jena framework). 
5. Then the result is serialized as translation output (OntModel in RDF/XML). 
