angular.module('app.services', [])
.factory('Record', function($resource) {
  return $resource('/api/v1/records/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
})
.factory('Genre', function($resource) {
	return $resource('/api/v1/genres');
})
.factory('Condition', function($resource) {
	return $resource('/api/v1/conditions');
})
.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
})
.service('Upload', function($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
     
        $http.post(uploadUrl, fd, {
           transformRequest: angular.identity,
           headers: {'Content-Type': undefined}
        })
        .success(function(){
        	console.log("ok");
        })
        .error(function(){
        	console.log("error");
        });
     }	
});
