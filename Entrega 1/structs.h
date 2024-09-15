#define MAX_LIMIT 256


struct filme
{
    int codigo;
    char titulo[MAX_LIMIT];
    int ano;
    char genero[MAX_LIMIT];
    int quantidade;
    int quantidade_total;
};

struct filme f[2000];