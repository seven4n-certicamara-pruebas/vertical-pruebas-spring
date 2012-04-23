Ejemplo Gradle con Ivy

Primero toca instalar gradle:
http://www.code-republic.com/?p=48

Luego instalar Ivy (y ant si es necesario):
http://olmex.blogspot.in/2012/04/ivy-beginners-guide.html
Capitulo 2

Con ivy instalado se crea un repositorio local:
http://olmex.blogspot.in/2012/04/ivy-beginners-guide.html
Capitulo 8

Al repositorio se le pueden importar jars creando un build.xml como el siguiente (corriéndolo con ant):

<project name="localrepository" default="install"
xmlns:ivy="antlib:org.apache.ivy.ant">
<target name="install" description="--> install modules to localreporsitory">
<ivy:install organisation="commons-lang" module="commons-lang"
revision="2.6" transitive="true" overwrite="false"
from="public" to="local"/>
</target>
</project>

para llenar los campos organisation, module y revision mirar el siguiente link:
http://ant.apache.org/ivy/history/latest-milestone/tutorial/start.html

Con todo esto listo se corre gradle; desde la consola se va a la carpeta donde se encuentra el proyecto y se corre el comando gradle.

Para este ejemplo se coloco el repositorio del ivy dentro del proyecto (la carpeta local). Es importante mencionar la sección repositories; como el repositorio creado no tiene la estructura de carpetas estándar de ivy entonces toca definir como es el patrón de esta estructura. Link sobre estos patrones:
http://gradle.org/docs/current/userguide/dependency_management.html#sec:ivy_repositories

El build.gradle también contiene el plugin eclipse, este se utilizo para crear las cosas necesarias para importar el proyecto a eclipse, mirar el siguiente ejemplo:
http://www.springsourcery.org/springSourcery/content/viewContent,1,42.html?random=2937