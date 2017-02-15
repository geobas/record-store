angular.module('app.services', []).factory('Record', function($resource) {
  return $resource('/api/v1/records/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
