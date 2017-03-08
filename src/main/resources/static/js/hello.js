var app = angular.module('shoppingCartModule',[]);
   app.controller('shoppingCart',function($scope){

     $scope.sportChannels = [
           {
              name: 'Arsenal'

           },
           {
               name:'Chelsea'
           }
       ];

       $scope.newsChannels = [
           {
              name: 'Sky News'

           },
           {
               name:'Sky Sports News'
           }
       ];

        $scope.selectedChannels=[];


        $scope.exist = function (item) {

            return $scope.selectedChannels.indexOf(item)> -1;
        };

        $scope.toggleSelection = function (item) {
            var idx = $scope.selectedChannels.indexOf(item);

            if(idx> -1){
                $scope.selectedChannels.splice(idx,1);
            } else{
                $scope.selectedChannels.push(item);
            }

        };




      });