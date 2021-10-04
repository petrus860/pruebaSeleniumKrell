# Each feature contains one feature
# Feature files use Gherkin language - bussiness language
Feature: Test searching a new word

  Scenario Outline: Buscar en Google la palabra
    Given el usuario abre el browser
    And acceptar las condiciones de google
    When buscamos la palabra automatización "<palabra>"
    And buscamos el link de la Wikipedia resultante
    Then comprobamos en qué año se hizo el primer proceso automático
    And realizamos un screenshot de la página de la Wikipedia
    And cerrar el browser el terminar las prueba
    Examples:
      | palabra         |
      | automatización  |