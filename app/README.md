> O que aconteceu quando você tentou voltar para a Tela 1 através do método
  de navegação convencional? Você conseguiu visualizar as informações
  digitadas anteriormente? O que aconteceu com as chamadas dos métodos do
  ciclo de vida da activity Tela 1?

Os valores dos campos na primeira tela foram apagados. Os métodos `onCreate`, `onStart` e `onResume`
foram chamados em ordem.

```log
ResultActivity: onPause
MainActivity: onCreate
MainActivity: onStart
MainActivity: onResume
ResultActivity: onStop
```

> Experimente adicionar a linha `it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)`, onde `it` é o
  objeto `Intent` criado para informar os o destino da navegação, antes do método que consuma a
  navegação e observe o que acontecerá com as chamadas dos métodos do ciclo de vida das activities.

O método `onRestart` da primeira tela foi chamado ao invés de `onCreate`.

```log
ResultActivity: onPause
MainActivity: onRestart
MainActivity: onStart
MainActivity: onResume
ResultActivity: onStop
```
