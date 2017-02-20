angular.module('app.controllers', [])
.controller('RecordsListController', function($scope, $state, popupService, $window, Record, $dialogs) {
  $scope.records = Record.query(); //fetch all records. Issues a GET to /api/vi/records

  $scope.deleteRecord = function(record) { // Delete a Record. Issues a DELETE to /api/v1/records/:id
	  dlg = $dialogs.confirm("Do you really really want to delete this record?", "", {size:'lg',keyboard: false,backdrop: false,windowClass: 'my-class'});
      dlg.result.then(function(){
        record.$delete(function() {
	        $scope.records = Record.query();
	        $state.go('records');
        });
      }, function(){
    	  // do nothing
      });
//    if (popupService.showPopup('Do you really really want to delete this record?')) {
//      record.$delete(function() {
//        $scope.records = Record.query();
//        $state.go('records');
//      });
//    }
  };
})
.controller('RecordViewController', function($scope, $stateParams, Record, Genre, Condition) {
  $scope.record = Record.get({ id: $stateParams.id }); //Get a single record.Issues a GET to /api/v1/records/:id
  $scope.genres = Genre.query();
  $scope.conditions = Condition.query();
})
.controller('RecordCreateController', function($scope, $state, $stateParams, Record, Genre, Condition) {
  $scope.record = new Record();  //create new record instance. Properties will be set via ng-model on UI
  $scope.addRecord = function() { //create a new record. Issues a POST to /api/v1/records
    $scope.record.$save(function() {
      $state.go('records'); // on success go back to the list i.e. records state.
    });
  };
  $scope.onlyNumbers = /^\d+$/;
  $scope.genres = Genre.query();
  $scope.conditions = Condition.query();
})
.controller('RecordEditController', function($scope, $state, $stateParams, Record, Genre, Condition) {
  $scope.updateRecord = function() { //Update the edited record. Issues a PUT to /api/v1/records/:id
    $scope.record.$update(function() {
      $state.go('records'); // on success go back to the list i.e. records state.
    });
  };

  $scope.loadRecord = function() { //Issues a GET request to /api/v1/records/:id to get a record to update
    $scope.record = Record.get({ id: $stateParams.id });
  };

  $scope.loadRecord(); // Load a record which can be edited on UI
  $scope.onlyNumbers = /^\d+$/;
  $scope.genres = Genre.query();
  $scope.conditions = Condition.query();
});
