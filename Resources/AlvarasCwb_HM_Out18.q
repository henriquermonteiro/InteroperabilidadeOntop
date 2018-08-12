[QueryItem="Alvaras"]
PREFIX : <http://www.semanticweb.org/ricardo/ontologies/2016/5/alvarasCwb#>
SELECT * WHERE {?licence a :Licence ; :hasName ?name }

[QueryItem="Category"]
PREFIX : <http://www.semanticweb.org/ricardo/ontologies/2016/5/alvarasCwb#>
SELECT * WHERE {?licence a :Licence ; :hasName ?name ; :hasA :Bar }
