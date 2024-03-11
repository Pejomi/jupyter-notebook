import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.metrics import f1_score

data = pd.read_csv('../Data/traffic_data/encoded_data.csv')

X = data.drop('Accident_Severity', axis=1)
y = data['Accident_Severity']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)


# Function for comparing different algorithms to find the best fit
def train_all():
    train_random_forest()
    train_decision_tree()
    train_knn()
    train_svc()


def train_random_forest():
    # Train a random forest classifier
    clf = RandomForestClassifier(n_estimators=50, random_state=42)
    clf.fit(X_train, y_train)

    # Make predictions
    y_pred = clf.predict(X_test)

    # Evaluate the model
    accuracy = accuracy_score(y_test, y_pred)
    f1 = f1_score(y_test, y_pred, average='weighted')
    print(f'Random Forest Accuracy: {accuracy:.2f}')
    print(f'Random Forest F1: {f1:.2f}')


def train_decision_tree():
    # Train a decision tree classifier
    clf = DecisionTreeClassifier(random_state=42)
    clf.fit(X_train, y_train)

    # Make predictions
    y_pred = clf.predict(X_test)

    # Evaluate the model
    accuracy = accuracy_score(y_test, y_pred)
    f1 = f1_score(y_test, y_pred, average='weighted')
    print(f'Decision Tree Accuracy: {accuracy:.2f}')
    print(f'Decision Tree F1: {f1:.2f}')


def train_knn():
    # Train a KNN classifier
    clf = KNeighborsClassifier(n_neighbors=15)
    clf.fit(X_train, y_train)

    # Make predictions
    y_pred = clf.predict(X_test)

    # Evaluate the model
    accuracy = accuracy_score(y_test, y_pred)
    f1 = f1_score(y_test, y_pred, average='weighted')
    print(f'KNN Accuracy: {accuracy:.2f}')
    print(f'KNN F1: {f1:.2f}')


def train_svc():
    # Train an SVC classifier
    clf = SVC(kernel='linear')
    clf.fit(X_train, y_train)

    # Make predictions
    y_pred = clf.predict(X_test)

    # Evaluate the model
    accuracy = accuracy_score(y_test, y_pred)
    f1 = f1_score(y_test, y_pred, average='weighted')
    print(f'SVC Accuracy: {accuracy:.2f}')
    print(f'SVC F1: {f1:.2f}')
