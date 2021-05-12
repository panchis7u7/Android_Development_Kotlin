###################################################################################
# Libraries.

import json
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

###################################################################################

def main():
    cred = credentials.Certificate(CERTIFICATE)
    firebase_admin.initialize_app(cred)
    store = firestore.client()
    doc_ref = store.collection(u'Prueba')
    docs = doc_ref.get()
    item_data = load_json(DATA_PATH + '/' +"B1T1.json")
    doc_ref.add(item_data)

if __name__ == "__main__":
    main()