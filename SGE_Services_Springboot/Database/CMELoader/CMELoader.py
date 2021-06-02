###################################################################################
# Libraries.

import json
from os import path, listdir

###################################################################################

###################################################################################
#Constants.

OUTPUT_FILE = "inserts-CME.sql"
SECONDARY_FILE = "inserts-morelia.sql"
DATA_PATH = "Michoacán de Ocampo"
TABLE_COLONIAS = "colonias"
TABLE_MUNICIPIOS = "municipios"
TABLE_ESTADOS = "estados"

###################################################################################

###################################################################################

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)

def main():
    coloniaID = 0 
    municipio = 0 
    estado = 0 
    open(OUTPUT_FILE, "w+")
    f = open(OUTPUT_FILE, 'a')
    estado+=1
    f.write("INSERT INTO {} VALUES ({}, '{}');\n".format(TABLE_ESTADOS, estado, DATA_PATH))

    for dir in listdir(DATA_PATH):
        municipio+=1
        f.write("INSERT INTO {} VALUES ({}, '{}', {});\n"
        .format(
            TABLE_MUNICIPIOS,
            municipio,
            dir.split('.')[0],
            estado
        ))

        data = load_json(DATA_PATH + '/' + dir)
        for colonia in data: 
            coloniaID += 1
            f.write("INSERT INTO {} VALUES ({}, '{}', '{}', {});\n"
            .format(
                TABLE_COLONIAS,
                coloniaID,
                colonia['nombre'],
                'null',
                municipio
            ))
    f.close()

def morelia():
    coloniaID = 0 
    municipio = 0 
    estado = 0 
    open(SECONDARY_FILE, "w+")
    f = open(SECONDARY_FILE, 'a')
    estado+=1
    f.write("INSERT INTO {} VALUES ({}, '{}');\n".format(TABLE_ESTADOS, estado, DATA_PATH))

    for dir in listdir(DATA_PATH):
        municipio+=1
        f.write("INSERT INTO {} VALUES ({}, '{}', {});\n"
        .format(
            TABLE_MUNICIPIOS,
            municipio,
            dir.split('.')[0],
            estado
        ))

        if(dir.split('.')[0] == "Morelia"):
            data = load_json(DATA_PATH + '/' + dir)
            for colonia in data: 
                coloniaID += 1
                f.write("INSERT INTO {} VALUES ({}, '{}', '{}', {});\n"
                .format(
                    TABLE_COLONIAS,
                    coloniaID,
                    colonia['nombre'],
                    'null',
                    municipio
                ))
    f.close()


###################################################################################

if __name__ == "__main__":
    morelia()