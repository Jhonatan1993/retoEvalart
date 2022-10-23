#language:en
#Autor: Jhonatan Paternina Rojas

@stories
Feature: Evalart
  Como usuario de evalart
  Quiero ingresar a la página evalartapp
  Para consultar las coordenadas de los botones correctos.

  @VerificarCoordenadas
  Scenario Outline: Verificar que al seleccionar una coordenada se seleccione el boton correcto
    Given que Jhonatan ingresa a la pagina evalartapp
      | username   | password   |
      | <username> | <password> |

    When el ingresa selecciona un boton
      | suma   |
      | <suma> |

    Then el verifica que el boton sea el correcto
      | coordenada   |
      | <coordenada> |

    Examples:
      | username | password                                         | coordenada | suma |
      | 474327   | 10df2f32286b7120My0zLTcyMzQ3NA==30e0c83e6c29f1c3 | coordenada | 12   |