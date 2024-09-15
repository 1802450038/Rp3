//Funcao para imprimir o array de filme
void print_filme(int i, int label) //OK
{
    if (label == 1)
    {
        printf("Codigo: %d\n", f[i].codigo);
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

//Imprime um filme especificado pelo nome do array de struct filme, caso ele exista

int impress_name(char nome[]) //OK
{
    encontrou = 0;
    for (i = 0; i < numero_filmes; i++)
    {
        if (strcmp(f[i].titulo, nome) == 0)
        {
            encontrou = 1;
            print_filme(i, 1);
        }
    }
    return encontrou;
}

//Imprime filmes de um determinado ano ou genero pesquisado.
int relatorio(char pesquisa[]) //OK
{
    char ano_char[MAX_LIMIT * 3];
    encontrou = 0;
    for (i = 0; i < numero_filmes; i++)
    {
        sprintf(ano_char, "%s%d", "", f[i].ano);

        if (strcmp(ano_char, pesquisa) == 0)
        {
            print_filme(i, 1);
            encontrou = 1;
        }
        else if (strcmp(f[i].genero, pesquisa) == 0)
        {
            print_filme(i, 1);
            encontrou = 1;
        }
    }
    return encontrou;
}