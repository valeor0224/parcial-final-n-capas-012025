# Parcial Final Programación N-Capas – (Seguridad con Spring Security + JWT)

Este repositorio contiene un proyecto para evaluar y practicar los conceptos de seguridad en aplicaciones Spring Boot usando JWT, roles y Docker.

### Estudiantes
- **Nombre del estudiante 1**: Valeria Elizabeth Ortiz Romero - 00206022
- **Nombre del estudiante 2**: Axel Jahir Alvarado Alegría - 00216022
- Sección: 02
---

**Instrucciones de registro:**
**Usuario - POST**

**Descripción:**

Este endpoint permite registrar un nuevo usuario en el sistema con rol asignado (`USER` o `TECH`).

**URL:**

`POST {{baseUrl}}/auth/register`

**¿Autenticación?:**

No

**Ejemplo cuerpo de la solicitud (JSON):**

```json
{
  "nombre": "Test",
  "correo": "test@correo.com",
  "password": "123456",
  "nombreRol": "USER"
}

```
**Instrucciones de Login**
**de Usuario - POST**

**Descripción:**

Este endpoint autentica permite autenticar y regresa un **token JWT**.

**URL:**

`POST {{baseUrl}}/auth/login`

**¿Autenticación?:**

No

**Ejemplo cuerpo de la solicitud (JSON):**

```json
{
  "correo": "tech@demo.com",
  "password": "123456"
}

```


## Sistema de Soporte Técnico

### Descripción
Simula un sistema donde los usuarios pueden crear solicitudes de soporte (tickets) y los técnicos pueden gestionarlas. Actualmente **no tiene seguridad implementada**.

Su tarea es **agregar autenticación y autorización** utilizando **Spring Security + JWT**, y contenerizar la aplicación con Docker.

### Requisitos generales

- Proyecto funcional al ser clonado y ejecutado con Docker.
- Uso de PostgreSQL (ya incluido en docker-compose).
- Seguridad implementada con JWT.
- Roles `USER` y `TECH`.
- Acceso restringido según el rol del usuario.
- Evidencia de funcionamiento (colección de Postman/Insomnia/Bruno o capturas de pantalla).

**Nota: El proyecto ya tiene una estructura básica de Spring Boot con endpoints funcionales para manejar tickets. No es necesario modificar la lógica de negocio, solo agregar seguridad. Ademas se inclye un postman collection para probar los endpoints. **

_Si van a crear mas endpoints como el login o registrarse recuerden actualizar postman/insomnia/bruno collection_

### Partes de desarrollo

#### Parte 1: Implementar login con JWT
- [ ] Crear endpoint `/auth/login`.
- [ ] Validar usuario y contraseña (puede estar en memoria o en BD).
- [ ] Retornar JWT firmado.

#### Parte 2: Configurar filtros y validación del token
- [ ] Crear filtro para validar el token en cada solicitud.
- [ ] Extraer usuario desde el JWT.
- [ ] Añadir a contexto de seguridad de Spring.

#### Parte 3: Proteger endpoints con Spring Security
- [ ] Permitir solo el acceso al login sin token.
- [ ] Proteger todos los demás endpoints.
- [ ] Manejar errores de autorización adecuadamente.

#### Parte 4: Aplicar roles a los endpoints

| Rol   | Acceso permitido                                 |
|--------|--------------------------------------------------|
| USER  | Crear tickets, ver solo sus tickets              |
| TECH  | Ver todos los tickets, actualizar estado         |

- [ ] Usar `@PreAuthorize` o reglas en el `SecurityFilterChain`.
- [ ] Validar que un USER solo vea sus tickets.
- [ ] Validar que solo un TECH pueda modificar tickets.

#### Parte 5: Agregar Docker
- [ ] `Dockerfile` funcional para la aplicación.
- [ ] `docker-compose.yml` que levante la app y la base de datos.
- [ ] Documentar cómo levantar el entorno (`docker compose up`).

#### Parte 6: Evidencia de pruebas
- [ ] Probar todos los flujos con Postman/Insomnia/Bruno.
- [ ] Mostrar que los roles se comportan correctamente.
- [ ] Incluir usuarios de prueba (`user`, `tech`) y contraseñas.



**Capturas:** 

**Register:**
![image](https://github.com/user-attachments/assets/8aba9293-e426-4365-be2f-1e3ed94d790f) 
**Login:**
![image](https://github.com/user-attachments/assets/276d448a-6d5e-4fac-b836-918c7f501387)

![image](https://github.com/user-attachments/assets/42becd8c-5bf7-4e45-a3b8-51982d9ad0fd)

![image](https://github.com/user-attachments/assets/ed2879eb-ef9c-44f9-8fba-ce04f5ce49aa)

![image](https://github.com/user-attachments/assets/ab2e7742-4697-4bdc-b554-6ab47c3e6cdb)

![image](https://github.com/user-attachments/assets/8ac15690-bc50-4e2e-9b09-443fb8e7c55d)

