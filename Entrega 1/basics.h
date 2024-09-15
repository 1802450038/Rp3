//Gera quebra de linhas passando o numero de linhas desejadas
//Ex: line(2);

void line(int nLines)
{
    for (size_t i = 0; i < nLines; i++)
    {
        printf("\n");
    }
}

//Gera tabulação passando o numero de tabulações desejadas
//Ex: tab(3);
//      Texto
void tab(int nTabs)
{
    for (size_t i = 0; i < nTabs; i++)
    {
        printf("\t");
    }
}
//Limpa o console
//Ex: clear();
void clear()
{
    system("clear");
}
//função para padronizar a impressao
//label 1 exibe o nome do campo na impressao e o 0 nao

void println(char text[])
{
    printf("%s\n", text);
}
