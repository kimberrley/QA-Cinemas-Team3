(function () {
    var UpdateScreenController = function (screenDal, $state, $stateParams) {
        var vm = this;
        function init() {
            screenDal.getScreenByID($stateParams.screenId).then(function (result) {
                vm.screen = result;
            }, function(error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();

        vm.updateScreen = function(screenToUpdate) {
            screenDal.updateScreen(screenToUpdate.screenId, screenToUpdate).then(function (result) {
                vm.screenUpdateMessage  = result;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
            $state.go('cms.managescreens', {}, { reload: true });
        };
    };
    angular.module('cinemaApp').controller('updateScreenController', ['screenDal', '$state', '$stateParams', UpdateScreenController]);
}());