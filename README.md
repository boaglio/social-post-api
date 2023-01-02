
# Social Post API

Uma API bem simples para divulgar vídeos do YouTube nas redes sociais. 

## Arquitetura

* Spring Boot 3.x
* Java 17+
* Twitter (twitter4j)
* jsoup (web crawler)

## Serviços suportados

* Discord
* Twitter

## Setup

Para o funcionamento correto, dentro de src/main/resources o sistema espera os arquivos:


* _discord.properties_ - webhook.url com a [URL do WebHook do Discord](https://support.discord.com/hc/pt-br/articles/228383668-Usando-Webhooks)

* _twitter4j.properties_ - credenciais da [app do Twitter](https://developer.twitter.com/en/portal/dashboard): oauth.consumerKey, oauth.consumerSecret, oauth.accessToken e oauth.accessTokenSecret

## Documentação 

### API

A documentação em formato *OpenAPI Specification* está disponível [online](http://localhost:8080/swagger-ui/index.html) quando o sistema subir. 

## Run 

Para executar o sistema localmente, execute:

```
mvn spring-boot:run
```

Em seguida acesse com o navegador: [http://localhost:8080](http://localhost:8080)
 
