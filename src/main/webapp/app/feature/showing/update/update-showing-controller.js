(function () {
    var UpdateShowingController = function (showingDal, $stateParams, $state) {
        var vm = this;
        function init() {
        	showingDal.getShowingByID($stateParams.showingId).then(function (result) {
            	vm.showing = result;
            }, function(error) {
            	vm.error = true;
            	vm.errorMessage = error;
            });
        }
        init();
        
        vm.updateShowing = function(showingToUpdate) {
            showingDal.updateShowing(showingToUpdate.showingId, showingToUpdate).then(function (result) {
                vm.showingUpdateMessage  = result;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
            $state.go('cms.manageshowings', {}, { reload: true });
        };
    };
    angular.module('cinemaApp').controller('updateShowingController', ['showingDal', '$stateParams', '$state', UpdateShowingController]);
}());