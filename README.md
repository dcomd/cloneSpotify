# cloneSpotify

# Arquitetura Mvvm e Clean Architeture
![Text](https://github.com/dcomd/mvvm-clean/blob/main/mvvm.png)

# Repository
Repository é o reponsável por abstrair as funcionalidade do romm e do retrofiti disponibilizando somente as implementações necessarias para camada de useCase.

 ## Qual problema resolve o Repository?
  Com o repository é possivel encapsular a logica das persistencia do room e do retrofit.
  
# UseCase
Se encontram nesta camada, as regras de negócios mais específicas do sistema e ainda, é o lugar onde será verificado como a camada de apresentação receberá os dados.

 ## Qual problema resolve o useCase?
   Com o useCase evitamos a duplicidade de regras de negócios.
   
# ViewModel
 A viewModel é reponsavel por acoplar especificas regras de negocios , ela extende de viewModel que significa que segue o ciclo de vida da activity e ou Fragment a mesma também consegue manter os valores da UI na vertical e horizontal.
 
 ## Qual problema resolve o viewModel?
   Com a viewModel podemos encapsular regras de negocios especifica da feature que não será duplicada.
