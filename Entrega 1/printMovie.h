//Funcao para imprimir o array de filme
void print_filme(int i, int label) //OK
{
    if (label == 1)
    {
        printf("codigo: %d\n", f[i].codigo);
        printf("Titulo: %s\n", f[i].titulo);
        printf("Ano: %d\n", f[i].ano);
        printf("Quantidade: %d\n", f[i].quantidade);
        printf("Genero: %s\n", f[i].genero);
        line(1);
    }
    else
    {
        printf("%d\n", f[i].codigo);
        printf("%s\n", f[i].titulo);
        printf("%d\n", f[i].ano);
        printf("%d\n", f[i].quantidade);
        printf("%s\n", f[i].genero);
    }
}

//Imprime as informações de todos os filmes presentes no array de struct filme
void impressao() //OK
{
    i = 0;
    while (i < numero_filmes)
    {
        print_filme(i, 1);
        i++;
    }
}