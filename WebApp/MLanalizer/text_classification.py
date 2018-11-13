import nltk
import random
from sklearn.svm import SVC, LinearSVC, NuSVC
from nltk.classify import ClassifierI
from sklearn.naive_bayes import MultinomialNB, BernoulliNB
from sklearn.linear_model import LogisticRegression, SGDClassifier
from statistics import mode
from nltk.tokenize import word_tokenize
from nltk.classify.scikitlearn import SklearnClassifier
import pickle


all_words = []
data = []

class classifier_banch(ClassifierI):
    def __init__(self, *classifiers):
        self.all_classefiers = classifiers

    def classify(self, features):
        votes = []
        for c in self.all_classefiers:
            v = c.classify(features)
            votes.append(v)
        return mode(votes)

short_pos = open("positive.txt","r").read()
short_neg = open("negative.txt","r").read()


onlyadj = ["J"]

for p in short_pos.split('\n'):
    data.append( (p, "pos") )
    words = word_tokenize(p)
    pos = nltk.pos_tag(words)
    for w in pos:
        if w[1][0] in onlyadj:
            all_words.append(w[0].lower())


for p in short_neg.split('\n'):
    data.append( (p, "neg") )
    words = word_tokenize(p)
    pos = nltk.pos_tag(words)
    for w in pos:
        if w[1][0] in onlyadj:
            all_words.append(w[0].lower())


save_data = open("data/data.pickle","wb")
pickle.dump(data, save_data)
save_data.close()

all_words = nltk.FreqDist(all_words)
word_features = list(all_words.keys())[:5000]


save_word_features = open("data/featur.pickle","wb")
pickle.dump(word_features, save_word_features)
save_word_features.close()


def find_features(document):
    words = word_tokenize(document)
    features = {}
    for w in word_features:
        features[w] = (w in words)

    return features

featuresets = [(find_features(rev), category) for (rev, category) in data]

random.shuffle(featuresets)
print(len(featuresets))

testing_set = featuresets[10000:]
training_set = featuresets[:10000]


berulli_clas = SklearnClassifier(BernoulliNB())
berulli_clas.train(training_set)

saving = open("data/bersnul.pickle","wb")
pickle.dump(berulli_clas, saving)
saving.close()

logist_reg_class = SklearnClassifier(LogisticRegression())
logist_reg_class.train(training_set)

saving = open("data/logist_reg.pickle","wb")
pickle.dump(logist_reg_class, saving)
saving.close()

LinearSVC_classifier = SklearnClassifier(LinearSVC())
LinearSVC_classifier.train(training_set)

saving = open("data/SVC.pickle","wb")
pickle.dump(LinearSVC_classifier, saving)
saving.close()

