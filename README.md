# Taller2.PrincipiosSolid
Presentado por: Jesus Albeiro Zuniga
              : Juan Esteban Mera
1)El taller solucionado ya implementamos toda la parte sqlLite y Arrays dunciona con cualquiera de los dos ,en la rama master se podra ver todo el codigo realizado
2)
El principio de diseño que le esta dando flexibilidad a la solucion es el principio de diseño Factory y el singleton.
El principio de diseño singleton nos permite crear instancias de repositorios globales unicas estas las almacenamos en un map.
El principio de diseño factory lo que hace es que se puede intercambiar entre diferentes implementaciones de repositorios sin modificar el codigo que los usa, aplicando 
3 principios Solid.
1.Principio de resposabilidad Unica.
2.Principio de abierto y cerrado.
3.Pincipio de inversion de dependencias.
Esto lo podemos utilizar en el Main donde podemos cambiar entre repositorios arrays y SQlite.
El principio que se viola es el de Segregación de Interfaces (ISP) ya que una iterfaz no debería verse obligada a depender de métodos que no utiliza
Esto significa que las interfaces deben ser específicas y contener solo los métodos necesarios para el comportamiento que representan.Es decir el mismo
principio nos ayuda a refactorizar la interfaz y dividiendola en dos una de escritura y otra de lectura con eso la aplicacion es mas flexible.

