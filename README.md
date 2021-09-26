# Author's Notes

I saw that there wasn't a specification in the OpenApi Spec stating that the email in the User schema was unique.
I took under the assumption it was unique, making it a primary key as it wouldn't exactly make sense for multiple
users to sign up with the same email.

I've used Apache Derby for my embedded database and used JPA for ORM as oppossed to using SQL. I hope this is okay,
this was personal preference, but if it wasn't, please do know I am more than happy to use SQL if that is what the
organisation uses.

# Practical Exercise

Please build a RESTful API server that fulfils the OpenApi Spec ([`openapi-spec.yml`](openapi-spec.yml)) using the
following technologies.

1. [Maven](https://maven.apache.org/)
1. [Spring Boot](https://spring.io/projects/spring-boot)

Feel free to use any Maven plugins or code generation you wish. It is also perfectly fine to use an embedded DB for
persistence like [H2](https://www.h2database.com/html/main.html).
