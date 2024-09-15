#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "variables.h"
#include "structs.h"
#include "basics.h"
#include "menuOpt.h"
#include "movieManager.h"
#include "printer.h"



int main(int argc, char const *argv[])
{
    append_filme();
    while (1)
    {
        menuOptions();
        int opt;
        char param[MAX_LIMIT] = "";
        int var;
        scanf("%d", &opt);
        setbuf(stdin, NULL);
        switch (opt)
        {
        case 1:
            printf("[1] - Realizar locacao:");
            line(1);
            do
            {
                printf("%s", "Digite o nome do filme desejado");
                tab(2);
                printf("%s", "[0]-Voltar ao menu anterior");
                line(1);
                scanf("%[^\n]s", param);
                setbuf(stdin, NULL);
                if (strcmp(param, "0") == 0 )
                {
                    break;
                }
                else
                {
                    var = alugar_filme(param);
                    line(1);
                }
            } while (var == 0);
            break;
        case 2:
            printf("[2] - Realizar entrega:");
            line(1);
            var = 0;
            do
            {
                printf("%s", "Digite o nome do filme a ser devolvido");
                tab(2);
                printf("%s", "[0]-Voltar ao menu anterior");
                line(1);
                scanf("%[^\n]s", param);
                setbuf(stdin, NULL);
                if (strcmp(param, "0") == 0)
                {
                    break;
                }
                else
                {
                    var = devolver_filme(param);
                    line(1);
                }
            } while (var == 0);

            break;
        case 3:
            printf("[3] - Buscar por titulo:");
            line(1);
            var = 0;
            do
            {
                printf("%s", "Digite o nome do filme que deseja procurar");
                tab(2);
                printf("%s", "[0]-Voltar ao menu anterior");
                line(1);
                scanf("%[^\n]s", param);
                setbuf(stdin, NULL);
                if (strcmp(param, "0") == 0)
                {
                    break;
                }
                else
                {
                    var = impress_name(param);
                    line(1);
                }
            } while (var == 0);

            break;
        case 4:
            printf("[4] - Listar acervo:");
            line(1);
            impressao();
            line(2);
            break;
        case 5:
            printf("[5] - Gerar Relatorios:");
            line(1);
            do
            {
                printf("%s", "Digite o ano ou gênero que deseja pesquisar:");
                tab(2);
                printf("%s", "[0]-Voltar ao menu anterior");
                line(1);
                scanf("%[^\n]s", param);
                setbuf(stdin, NULL);
                if (strcmp(param, "0") == 0)
                {
                    break;
                }
                else
                {
                    var = relatorio(param);
                    line(2);
                }
            } while (var == 0);
            break;

        case 0:
            printf("[0] - Ate mais :,( ");
            line(2);
            exit(0);
            break;
        default:
            printf("[404] - Opcao nao encontrada, tente novamente!!");
            line(2);
            break;
        }
    }
}
