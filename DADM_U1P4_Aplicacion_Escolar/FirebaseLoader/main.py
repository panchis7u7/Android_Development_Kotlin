###################################################################################
# Libraries.

import json
import firebase_admin
from firebase_admin import credentials, firestore

###################################################################################

###################################################################################
# Firebase API needs.

CERTIFICATE = "./key.json"
DATA_PATH = "data"

###################################################################################

def main():
    cred = credentials.Certificate(CERTIFICATE)
    firebase_admin.initialize_app(cred)
    store = firestore.client()
    doc_ref = store.collection(u'Prueba')
    docs = doc_ref.get()

if __name__ == "__main__":
    main()