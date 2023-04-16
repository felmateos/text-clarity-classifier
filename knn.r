setwd("/home/chocomenta/Desktop/code/R")
dataset = read.csv2("jogo.csv", header = TRUE, sep = ";")
head(dataset)

knn <- function(dataset, query, k=1){

classId = ncol(dataset)
E = apply(dataset, 1, function(row){ #arg2 1 linha 2 coluna
            sqrt(sum((query-as.numeric(row[1:(classId-1)]))^2))
        })

ids = sort.list(E, dec=F)[1:k]
classes = dataset[ids,classId]
U = unique(classes)
R = rep(0, length(U))

for(i in 1:length(U)){
    R[i] = sum(U[i] == classes)
}

ret = list()
ret$U = U
ret$R = R

return (ret)

}


knn(dataset, c(34,78), k=1)

