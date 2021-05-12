###################################################################################
# Libraries.

import json
import os
import firebase_admin
from firebase_admin import credentials, firestore

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

# Create all school subjects in a semester directory.
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
    firebase_admin.initialize_app(cred)
    store = firestore.client()
    doc_ref = store.collection(u'Prueba')
    docs = doc_ref.get()
    item_data = load_json(DATA_PATH + '/' +"B1T1.json")
    doc_ref.add(item_data)

if __name__ == "__main__":
    main()