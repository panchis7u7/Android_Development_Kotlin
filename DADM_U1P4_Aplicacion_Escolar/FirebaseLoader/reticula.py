###################################################################################
# Libraries.

import json
import os
import firebase_admin
from os import listdir
from firebase_admin import credentials, firestore, auth

###################################################################################

###################################################################################
# Firebase API needs.

CERTIFICATE = "./key.json"
DATA_PATH = "reticula"

###################################################################################

###################################################################################
# Utility functions.

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)

# Create all school subjects in a directory.
def populate_data_template(semestres, materias):
    for x in range(1, semestres+1):
        dir_path = DATA_PATH + '/semestre' + str(x) 
        os.mkdir(dir_path)
        for y in range(1, materias+1):
            open(dir_path + '/' + 'B'+str(x)+'T'+str(y)+".json", 'w+')

###################################################################################

def main():
    #populate_data_template(9, 6)
    cred = credentials.Certificate(CERTIFICATE)
    app = firebase_admin.initialize_app(cred)
    store = firestore.client()
    userid = auth.get_user_by_email("smadrigal.rod@gmail.com", app).uid
    doc_ref = store.collection(u"alumnos/" + userid + "/materias")
    docs = doc_ref.get()
    #item_data = load_json(DATA_PATH + '/' +"B1T1.json")
    #doc_ref.add(item_data)
    for dir in listdir(DATA_PATH):
        for materia in listdir(DATA_PATH + '/' + dir):
            data = load_json(DATA_PATH + '/' + dir + '/' + materia)
            doc_ref.add(data)
            print("File added: " + materia)

if __name__ == "__reticula__":
    main()