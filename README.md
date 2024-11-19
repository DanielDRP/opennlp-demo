Code to accompany Phil's June 2015 Tri-JUG presentation
on OpenNLP.

# Práctica 4: Control de versiones

En esta práctica se desarrolla un pequeño código en Java que utiliza la librería OpenNLP para realizar un análisis de texto. El código se ha desarrollado en un repositorio de GitHub y se ha utilizado la herramienta SonarCloud para analizar la calidad del código.

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=DanielDRP_opennlp-demo)](https://sonarcloud.io/summary/new_code?id=DanielDRP_opennlp-demo)

---
## Información sobre la práctica
* **Alumno**: Daniel Del Rosario Pimienta
* **Alu**: alu0101315577
* **Herramientas utilizadas:**
  * **OpenNLP**: Biblioteca para tareas de procesamiento de lenguaje natural.
  * **SonarCloud**: Plataforma para análisis de calidad del código.
  * **Doxygen**: Herramienta para la generación de documentación a partir de código fuente.
  * **Maven**: Herramienta de gestión de proyectos de software.
    * **OWASP**: Herramienta para análisis de seguridad en aplicaciones web.
    * **PMD**: Herramienta para análisis de código fuente.
    * **Checkstyle**: Herramienta para análisis de estilo de código.

--- 
## **Recursos y Referencias**
- 📘 **Documentación Oficial**:  
  [OpenNLP Manual](http://opennlp.apache.org/documentation/1.5.3/manual/opennlp.html)

- 📂 **Fuentes de datos para entrenamiento**:
    - [Etiquetador POS en formato TreeBank II](http://stackoverflow.com/questions/8949517/is-there-any-treebank-for-free)
    - [Conjunto de datos para Chunking](http://www.cnts.ua.ac.be/conll2000/chunking/)
    - [Textos en inglés para entrenamiento](http://www.gutenberg.org)

---

## **Instrucciones**
1. Clona el repositorio:
   ```bash
   git clone https://github.com/DanielDRP/opennlp-demo.git
   ```
2. Asegúrate de tener **Maven** y **Java 17** instalados.
3. Compila y ejecuta el proyecto desde el directorio raíz:
   ```bash
   mvn clean install
   java -jar target/nlp-demo1-0.0.1-SNAPSHOT.jar
   ```

