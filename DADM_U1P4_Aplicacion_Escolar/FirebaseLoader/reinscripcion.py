###################################################################################
# Libraries.

import json
import os
import firebase_admin
import random
from os import listdir
from firebase_admin import credentials, firestore, auth

###################################################################################

###################################################################################
# Firebase API needs.

CERTIFICATE = "./key.json"
DATA_PATH = "reinscripcion"

###################################################################################

###################################################################################
# Utility functions.

def load_json(file_path):
    with open(file_path, 'r') as f:
        return json.load(f)

# Create all reinscription school subjects schedules in a directory.
def populate_data_template():
    for dir in listdir("reticula"):
        dir_path = DATA_PATH + '/' + dir
        os.mkdir(dir_path)
        for materia in listdir("reticula" + '/' + dir):
            mat = materia.split('.')
            randnum = random.randint(1,3)
            for num in range(1,randnum+1):
                if(num == 1):
                    open(dir_path + '/' + materia, 'w+')
                elif (num == 2):
                    open(dir_path + '/' + mat[0] + 'B' + '.json', 'w+')
                    
###################################################################################

def main():
    #populate_data_template()
    cred = credentials.Certificate(CERTIFICATE)
    app = firebase_admin.initialize_app(cred)
    store = firestore.client()
    userid = auth.get_user_by_email("smadrigal.rod@gmail.com", app).uid
    doc_ref = store.collection(u"carreras/ITICs/reinscripcion")
    docs = doc_ref.get()
    #item_data = load_json(DATA_PATH + '/' +"B1T1.json")
    #doc_ref.add(item_data)
    for dir in listdir(DATA_PATH):
        for materia in listdir(DATA_PATH + '/' + dir):
            data = load_json(DATA_PATH + '/' + dir + '/' + materia)
            doc_ref.add(data)
            print("File added: " + materia)

if __name__ == "__main__":
    main()