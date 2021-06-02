import json
import os
from os import path
from os import listdir

###################################################################################
#SQL definitions.

INSERTS_FILE = "./inserts.sql"
TABLE_SUBJETCS = "asignaturas"
TABLE_PROFESORS = "profesores"
DATA_PATH = "reticula"

###################################################################################

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)
        
def main():
    open(INSERTS_FILE, "w+")
    f = open(INSERTS_FILE, 'a')
    for dir in listdir(DATA_PATH):
        for materia in listdir(DATA_PATH + '/' + dir):
            data = load_json(DATA_PATH + '/' + dir + '/' + materia)
            horarios = ["","","","",""]
            aulas = ["","","","",""]
            if(not(data.get('horarios') is None)):
                for index, horario in enumerate(data['horarios']):
                    horarios[index] = horario

            if(not(data.get('aulas') is None)):
                for index, aula in enumerate(data['aulas']):
                    aulas[index] = aula
                
            print("INSERT INTO {} VALUES ('{}', '{}', '{}', {}, {}, {}, '{}', '{}', '{}', {});"
            .format(
                TABLE_SUBJETCS,
                data['materia'],
                data['clave'],
                data['grupo'],
                data['creditos'],
                data['semestre'],
                data['semestre_cursada'],
                data['calificacion'],
                data['regularizacion'],
                data['evaluacion'],
                data['observaciones']
                ))


if __name__ == "__main__":
    main()