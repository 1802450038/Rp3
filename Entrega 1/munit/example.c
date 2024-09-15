#include "munit.h"
#include "munit.c"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../variables.h"
#include "../structs.h"
#include "../basics.h"
#include "../menuOpt.h"
#include "../movieManager.h"
#include "../printer.h"

static MunitResult
test_relatorio(const MunitParameter params[], void *data)
{
  char *gen = munit_parameters_get(params, "genero");
  char *ano = munit_parameters_get(params, "ano");
  int result = relatorio(ano);
  int result2 = relatorio(gen);
  if (result == 1 && result2 == 1)
  {
    return MUNIT_OK;
  }
  else
  {
    return MUNIT_FAIL;
  }
}

static char *gen_params[] = {
    "DRAMA",
    "ROMANCE",
    "DESENHO",
    "COMEDIA",
    "TERROR",
    "DOCUMENTARIO",
    "CULT",
    "PRONOME NEUTRO",
    NULL};

static char *ano_params[] = {
    "1995",
    "1996",
    "1997",
    "1998",
    "1999",
    "2000",
    "2001",
    "2002",
    "2003",
    "2004",
    "2005",
    "2006",
    "2007",
    "2008",
    "2009",
    "2010",
    NULL};

static MunitParameterEnum test_p[] = {
    {(char *)"genero", gen_params},
    {(char *)"ano", ano_params},
    {NULL, NULL},
};

static MunitResult
test_impress_name(const MunitParameter params[], void *data)
{
  char *name = munit_parameters_get(params, "name");
  if (impress_name(name) == 1)
  {
    return MUNIT_OK;
  }
  else
  {
    return MUNIT_FAIL;
  }
}

static char *name_params[] = {
    "O DOSSIE DE ODESSA",
    "10 ANOS SEM TANCREDO",
    "100 ANOS DE LUCIO COSTA",
    "11 DE SETEMBRO",
    "13 DIAS QUE ABALARAM O MUNDO",
    "1492 A CONQUISTA DO PARAISO",
    "15 FILHOS",
    "3 DIAS DO CONDOR",
    "68 CONFLITOS DE GERACOES",
    "68 CONFLITOS DE GERACOES",
    "A",
    "A ANO EM QUE MEUS PAIS SAIRAM DE FERIAS",
    "A ARTE NO III REICH A ARTE DA PROPAGANDA 2 FITAS",
    "A BAIA DO ODIO",
    "A BATALHA NO CHILE A INSURREICAO DA BURGUESIA",
    "A BATALHA NO CHILE O PODER POPULAR",
    "A BATALHA NO CHILE O GOLPE DE ESTADO",
    "A CAPTURA DO CARRASCO",
    "A CASA DOS ESPIRITOS",
    "A CASA DOS ESPIRITOS 2 FITAS",
    "A CHACINA DOS CORONEIS",
    "A CLASSE OPERARIA VAI AO PARAISO",
    "A CONFISSOES DE SCHMIDT",
    "A CONSTRUCAO DA LEITURA E DA ESCRITA DO ADULTO",
    "A COR DO SEU DESTINO",
    "A CORAGEM DE SER",
    "A CORPORACAO",
    "A CORPORACAO",
    "A CRISE DO PLANO REAL",
    "A CRISE NO CANAL DE SUEZ",
    "A CULTURA NO BRASIL NA DECADA DE 70 DOC",
    "A EPOCA DA INOCENCIA",
    "A ERA DO GELO",
    "A ESCOLA DAS AMERICAS ARMAS E AVAREZ",
    "A EXCECAO A REGRA",
    "A EXCENTRICA FAMILIA DE ANTONIA",
    "A FRATENIDADE E VERMELHA",
    "A FUGA",
    "A FUGA DAS GALINHAS",
    "A FUGA DAS GALINHAS 2 FITAS",
    "ROBERTAO",
    "ZECA",
    "LUCRENCIO",
    "DOUGRAS",
    "PEDRO",
    "ANDRE",
    "TIAGO ZEBEDEU",
    "TIAGO ALFEU",
    "JOAO",
    "FILIPE",
    "BARTOLOMEU",
    "TOME",
    "MATEUS",
    "TADEU",
    "SIMAO",
    "JUDAS",
    NULL};

static MunitParameterEnum test_n[] = {
    {(char *)"name", name_params},
    {NULL, NULL},
};

static MunitResult
test_alugar_filme(const MunitParameter params[], void *data)
{
  char *name = munit_parameters_get(params, "name");
  if (alugar_filme(name) == 1)
  {
    return MUNIT_OK;
  }
  else
  {
    return MUNIT_FAIL;
  }
}

static char *aluga_params[] = {
    "O DOSSIE DE ODESSA",
    "10 ANOS SEM TANCREDO",
    "100 ANOS DE LUCIO COSTA",
    "11 DE SETEMBRO",
    "13 DIAS QUE ABALARAM O MUNDO",
    "1492 A CONQUISTA DO PARAISO",
    "15 FILHOS",
    "3 DIAS DO CONDOR",
    "68 CONFLITOS DE GERACOES",
    "68 CONFLITOS DE GERACOES",
    "A",
    "A ANO EM QUE MEUS PAIS SAIRAM DE FERIAS",
    "A ARTE NO III REICH A ARTE DA PROPAGANDA 2 FITAS",
    "A BAIA DO ODIO",
    "A BATALHA NO CHILE A INSURREICAO DA BURGUESIA",
    "A BATALHA NO CHILE O PODER POPULAR",
    "A BATALHA NO CHILE O GOLPE DE ESTADO",
    "A CAPTURA DO CARRASCO",
    "A CASA DOS ESPIRITOS",
    "A CASA DOS ESPIRITOS 2 FITAS",
    "A CHACINA DOS CORONEIS",
    "A CLASSE OPERARIA VAI AO PARAISO",
    "A CONFISSOES DE SCHMIDT",
    "A CONSTRUCAO DA LEITURA E DA ESCRITA DO ADULTO",
    "A COR DO SEU DESTINO",
    "A CORAGEM DE SER",
    "A CORPORACAO",
    "A CORPORACAO",
    "A CRISE DO PLANO REAL",
    "A CRISE NO CANAL DE SUEZ",
    "A CULTURA NO BRASIL NA DECADA DE 70 DOC",
    "A EPOCA DA INOCENCIA",
    "A ERA DO GELO",
    "A ESCOLA DAS AMERICAS ARMAS E AVAREZ",
    "A EXCECAO A REGRA",
    "A EXCENTRICA FAMILIA DE ANTONIA",
    "A FRATENIDADE E VERMELHA",
    "A FUGA",
    "A FUGA DAS GALINHAS",
    "A FUGA DAS GALINHAS 2 FITAS",
    "ROBERTAO",
    "ZECA",
    "LUCRENCIO",
    "DOUGRAS",
    "PEDRO",
    "ANDRE",
    "TIAGO ZEBEDEU",
    "TIAGO ALFEU",
    "JOAO",
    "FILIPE",
    "BARTOLOMEU",
    "TOME",
    "MATEUS",
    "TADEU",
    "SIMAO",
    "JUDAS",
    NULL};

static MunitParameterEnum test_a[] = {
    {(char *)"name", aluga_params},
    {NULL, NULL},
};

static MunitResult
test_devolver_filme(const MunitParameter params[], void *data)
{
  char *name = munit_parameters_get(params, "name");
  if (devolver_filme(name) == 1)
  {
    return MUNIT_OK;
  }
  else if (devolver_filme(name) == 2)
  {
    return MUNIT_ERROR;
  }
  else
  {
    return MUNIT_FAIL;
  }
  
}

static char *devolver_params[] = {
    "O DOSSIE DE ODESSA",
    "10 ANOS SEM TANCREDO",
    "100 ANOS DE LUCIO COSTA",
    "11 DE SETEMBRO",
    "13 DIAS QUE ABALARAM O MUNDO",
    "1492 A CONQUISTA DO PARAISO",
    "15 FILHOS",
    "3 DIAS DO CONDOR",
    "68 CONFLITOS DE GERACOES",
    "68 CONFLITOS DE GERACOES",
    "A",
    "A ANO EM QUE MEUS PAIS SAIRAM DE FERIAS",
    "A ARTE NO III REICH A ARTE DA PROPAGANDA 2 FITAS",
    "A BAIA DO ODIO",
    "A BATALHA NO CHILE A INSURREICAO DA BURGUESIA",
    "A BATALHA NO CHILE O PODER POPULAR",
    "A BATALHA NO CHILE O GOLPE DE ESTADO",
    "A CAPTURA DO CARRASCO",
    "A CASA DOS ESPIRITOS",
    "A CASA DOS ESPIRITOS 2 FITAS",
    "A CHACINA DOS CORONEIS",
    "A CLASSE OPERARIA VAI AO PARAISO",
    "A CONFISSOES DE SCHMIDT",
    "A CONSTRUCAO DA LEITURA E DA ESCRITA DO ADULTO",
    "A COR DO SEU DESTINO",
    "A CORAGEM DE SER",
    "A CORPORACAO",
    "A CORPORACAO",
    "A CRISE DO PLANO REAL",
    "A CRISE NO CANAL DE SUEZ",
    "A CULTURA NO BRASIL NA DECADA DE 70 DOC",
    "A EPOCA DA INOCENCIA",
    "A ERA DO GELO",
    "A ESCOLA DAS AMERICAS ARMAS E AVAREZ",
    "A EXCECAO A REGRA",
    "A EXCENTRICA FAMILIA DE ANTONIA",
    "A FRATENIDADE E VERMELHA",
    "A FUGA",
    "A FUGA DAS GALINHAS",
    "A FUGA DAS GALINHAS 2 FITAS",
    "ROBERTAO",
    "ZECA",
    "LUCRENCIO",
    "DOUGRAS",
    "PEDRO",
    "ANDRE",
    "TIAGO ZEBEDEU",
    "TIAGO ALFEU",
    "JOAO",
    "FILIPE",
    "BARTOLOMEU",
    "TOME",
    "MATEUS",
    "TADEU",
    "SIMAO",
    "JUDAS",
    NULL};

static MunitParameterEnum test_d[] = {
    {(char *)"name", devolver_params},
    {NULL, NULL},
};

static MunitResult
test_appendFilme(const MunitParameter params[], void *user_data)
{
  if (f == NULL)
  {
    return MUNIT_FAIL;
  }
  else
  {
    return MUNIT_OK;
  }
}

static MunitResult
test_backup_acervo(const MunitParameter params[], void *user_data)
{

  if (backup_acervo() == 0)
  {
    return MUNIT_FAIL;
  }
  else if (backup_acervo() != 0)
  {
    return MUNIT_OK;
  }
}

static void *
test_append_setup(const MunitParameter params[], void *user_data)
{
  append_filme();
}

static MunitTest test_suite_tests[] = {

    {(char *)"/example/relatorio",
     test_relatorio,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     test_p},

    {(char *)"/example/appendFilme",
     test_appendFilme,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     NULL},

    {(char *)"/example/impress_name",
     test_impress_name,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     test_n},

    {(char *)"/example/backup_acervo",
     test_backup_acervo,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     NULL},

    {(char *)"/example/alugar_filme",
     test_alugar_filme,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     test_a},

    {(char *)"/example/devolver_filme",
     test_devolver_filme,
     test_append_setup,
     NULL,
     MUNIT_TEST_OPTION_NONE,
     test_d},
};

static const MunitSuite test_suite = {

    (char *)"",

    test_suite_tests,

    NULL,

    1,

    MUNIT_SUITE_OPTION_NONE};

int main(int argc, char *argv[MUNIT_ARRAY_PARAM(argc + 1)])
{

  return munit_suite_main(&test_suite, (void *)"µnit", argc, argv);
}
