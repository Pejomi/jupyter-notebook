import pandas as pd
import numpy as np
from joblib import load
import argparse

def predict(input_csv):
    input_data = pd.read_csv(input_csv)
    
    model_loaded = load('rf_model.joblib')
    prediction = model_loaded.predict(input_data)
    
    return prediction

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Execute predict from the command line.")
    parser.add_argument('param1', type=str, help='Input data in csv format')
    args = parser.parse_args()
    
    print(predict(args.param1))
