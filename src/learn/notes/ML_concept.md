
data engineering - feature engineering - model - matrix

classification
	Binary - yes/no.
	Multiclass
		It can classify data between more then three classes. 
		fashion mnist which classify data for shirt, pants & shoes etc.
	Multilevel 
		classify one or more level to each data point. One lady holding a 
		handbag and wearing sunglasses to classify this in single image.

loss
	Root mean squared error
	cross entropy
		Binary  - Single level 1/0
		sparse - Multiple label


Optimization 
	PARETO optimization - combining multiple loss functions in one 
	Adam, Momentum, SGD
	
ML system -
	mars  - maintainability, Adoptability, reliability, scalability 
	
	
Data life cycle	in ML
	collecting
	sampling
	labeling 
	
Data Lineage - Keep track of old and new data source for testing model performance


Data labeling tool
	snorkel -stanford AI lab

Data Imbalance -
	For each feature there is a balanced data
	
         Precision = True Positive / (True Positive + False Positive)
         Recall = True Positive / (True Positive + False Negative)
         F1 = 2 × Precision × Recall / (Precision + Recall)
         
AutoML

Recommender system 
	Collaborative learning / matrix factorization
	
	
Conferences for machine learning -  NeurIPS, ICLR, and ICML 

This area of research is known as architectural search, or neural architecture search (NAS) for neural networks, as it searches for the optimal model architecture.

Low Rank Factorization
knowledge distillation 
Pruning - remove datasets are not used for nerual network training 
WASM  - cross model compilation 
 
![Alt text](image/ML_batch_edge.png?raw=true "Title")
    