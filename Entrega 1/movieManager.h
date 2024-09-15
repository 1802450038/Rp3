//Cria um array de struct filme para salvar as informações dos filmes do .txt
//para serem manipulados diretamente da memória
void append_filme()
{

    FILE *pont_arq;
    char texto_str[MAX_LIMIT];
    char info[4][MAX_LIMIT];
    char concat[MAX_LIMIT];
    char str;
    pont_arq = fopen("entrada.txt", "r");

    //leitura da primeira linha do arquivo
    fgets(texto_str, MAX_LIMIT, pont_arq);

    //selecionando o numero de filmes
    numero_filmes = atoi(texto_str);

    while (fgets(texto_str, MAX_LIMIT, pont_arq) != NULL)
    {
        // strcspn retorna a primeira ocorrencia do caracter informado, nesse caso "\n"
        int pos_enter = strcspn(texto_str, "\n");

        // encerra a string na posição onde tinha enter
        texto_str[pos_enter] = 0;
        char *ptr = strtok(texto_str, ";");

        while (ptr != NULL)
        {
            for (int v = 0; v < 4; v++)
            {
                int k = 0;
                strcpy(&info[v][k], ptr);
                k++;
                ptr = strtok(NULL, ";");
            }
            char temp[256];
            f[i].codigo = i + 1;

            strcpy(f[i].titulo, &info[0][0]);
            strcpy(temp, &info[1][0]);
            f[i].ano = atoi(temp);
            strcpy(temp, &info[2][0]);
            f[i].quantidade = atoi(temp);
            f[i].quantidade_total = atoi(temp);
            f[i].quantidade = f[i].quantidade_total;
            strcpy(f[i].genero, &info[3][0]);
            if (i < numero_filmes)
            {
                i++;
            }
            else
            {
                break;
            }

            memset(info, 0, MAX_LIMIT);
        }
    }
    fclose(pont_arq);
}

//Salva as alterações feitas no array da struct filme de volta para o arquivo .txt
void backup_acervo() //OK
{
    char backup[] = "backup.txt";
    FILE *acervo = fopen(backup, "w");
    if (acervo == NULL)
    {
        printf("Problemas com a abertura do arquivo: %s", backup);
        return;
    }
    fprintf(acervo, "%d\n", numero_filmes);
    char linha[1000];
    for (int i = 0; i < numero_filmes; i++)
    {
        sprintf(linha, "%s;%d;%d;%s\n", f[i].titulo, f[i].ano, f[i].quantidade, f[i].genero);
        fprintf(acervo, "%s", linha);
    }

    fclose(acervo);
    printf("Backup do acervo realizado\n\n");
}
//Aluga  um filme, altera a quantidade de filmes disponíveis no acervos e salva a atualização
//no .txt de entrada
int alugar_filme(char titulo_filme[]) //0K
{
    encontrou = 0;

    for (int i = 0; i < numero_filmes; i++)
    {
        if (strcmp(f[i].titulo, titulo_filme) == 0)
        {

            if (f[i].quantidade > 0 && f[i].quantidade <= f[i].quantidade_total)
            {
                f[i].quantidade = f[i].quantidade - 1;
                encontrou = 1;

                printf("O filme '%s' foi alugado com sucesso! ", titulo_filme);
                backup_acervo();
            }
            else
            {
                printf("Não há filmes disponíveis para alugar! ");
                encontrou = 2;
            }
        }
    }
    if (encontrou == 0)
    {
        printf("O filme %s não foi encontrado! \n\n", titulo_filme);
    }
    return encontrou;
}
//Devolve um filme e atualiza a quantidade disponivel do filme devolvido no txt de entrada
int devolver_filme(char titulo_filme[]) //0k
{
    printf("\nTitulo digitado: %s\n", titulo_filme);
    encontrou = 0;
    for (int i = 0; i < numero_filmes; i++)
    {

        if (strcmp(f[i].titulo, titulo_filme) == 0)
        {
            if (f[i].quantidade >= 0 && f[i].quantidade < f[i].quantidade_total)
            {
                f[i].quantidade = f[i].quantidade + 1;
                encontrou = 1;
                printf("O filme '%s' foi devolvido com sucesso! ", titulo_filme);
                backup_acervo();
            }
            else
            {
                printf("Todos os exemplares de %s já estão na locadora! ", titulo_filme);
                encontrou = 2;
            }
        }
    }
    if (encontrou == 0)
    {
        printf("O filme %s não foi encontrado! \n\n", titulo_filme);
    }
    return encontrou;
}
