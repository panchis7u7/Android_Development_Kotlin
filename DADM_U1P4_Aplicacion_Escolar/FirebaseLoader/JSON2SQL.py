import json
from os import path
from os import listdir

###################################################################################
#SQL definitions.

INSERTS_FILE = "insertsReinscripcion.sql"
TABLE_SUBJETCS = "asignaturas"
TABLE_PROFESORS = "profesores"
TABLE_GRUPOS = "grupos"
TABLE_SUBJECTS_PROFESORS = "asignaturas_profesores"
DATA_PATH = "reinscripcion"

###################################################################################

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)
        
def main():
    materias = 0
    profesores = 0
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
            
            if(data['profesor'] != ""):
                profesores += 1
                f.write("INSERT INTO {} VALUES ({}, '{}');\n"
                .format(
                    TABLE_PROFESORS,
                    profesores,
                    data['profesor']
                ))

            
            materias += 1
            f.write("INSERT INTO {} VALUES ({}, '{}', '{}', '{}', {}, {}, {}, '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', {}, '{}', '{}', '{}', {});\n"
            .format(
                TABLE_SUBJETCS,
                materias,
                data['materia'],
                data['clave'],
                data['grupo'],
                data['creditos'],
                data['semestre'],
                data['semestre_cursada'],
                horarios[0],
                horarios[1],
                horarios[2],
                horarios[3],
                horarios[4],
                aulas[0],
                aulas[1],
                aulas[2],
                aulas[3],
                aulas[4],
                'null' if (data['calificacion'] == '') else data['calificacion'],
                data['regularizacion'],
                data['evaluacion'],
                data['observaciones'],
                'null' if data['profesor'] == '' else profesores
                ))

            if(data['profesor'] != ''):
                f.write("INSERT INTO {} VALUES ({}, {});\n".format(
                    TABLE_SUBJECTS_PROFESORS,
                    materias,
                    profesores
                ))

    f.close()


def reinscripcion():
    grupos = 0
    materias = 1
    profesores = 1
    open(INSERTS_FILE, "w+")
    f = open(INSERTS_FILE, 'a')
    for dir in listdir(DATA_PATH):
        print(dir)
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

            if(data['grupo'] != 'B'):
                materias += 1
                profesores += 1

            #materias += 1
            grupos += 1
            f.write("INSERT INTO {} VALUES ('{}', {}, {}, {}, '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}');\n"
            .format(
                TABLE_GRUPOS,
                materia.split('.')[0],
                grupos,
                materias,
                profesores,
                data['grupo'],
                horarios[0],
                horarios[1],
                horarios[2],
                horarios[3],
                horarios[4],
                aulas[0],
                aulas[1],
                aulas[2],
                aulas[3],
                aulas[4]
                ))

    f.close()

if __name__ == "__main__":
    reinscripcion()