import nltk
import random
from sklearn.naive_bayes import MultinomialNB, BernoulliNB
from nltk.tokenize import word_tokenize
from sklearn.linear_model import LogisticRegression, SGDClassifier
from sklearn.svm import SVC, LinearSVC, NuSVC
from nltk.classify import ClassifierI
from statistics import mode
from nltk.classify.scikitlearn import SklearnClassifier
import pickle

class VoteClassifier(ClassifierI):
    def __init__(self, *classifiers):
        self._classifiers = classifiers

    def classify(self, features):
        votes = []
        for c in self._classifiers:
            v = c.classify(features)
            votes.append(v)
        return mode(votes)

docf = open("data/documents.pickle", "rb")
doc = pickle.load(docf)
docf.close()

feature_set = open("data/words_feat.pickle", "rb")
word_features = pickle.load(feature_set)
feature_set.close()


def find_features(document):
    words = word_tokenize(document)
    features = {}
    for w in word_features:
        features[w] = (w in words)

    return features


openf = open("data/Bernoulli.pickle", "rb")
Bernoulli = pickle.load(openf)
openf.close()


openf = open("data/LogisticReg.pickle", "rb")
LogisticReg = pickle.load(openf)
openf.close()


openf = open("data/SVC.pickle", "rb")
SVC = pickle.load(openf)
openf.close()

voted_classifier = VoteClassifier(
                                  SVC,
                                  Bernoulli,
                                  LogisticReg)

def sentiment(text):
    feats = find_features(text)
    return voted_classifier.classify(feats)
