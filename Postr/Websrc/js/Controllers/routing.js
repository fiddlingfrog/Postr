postrApp.config(function($routeProvider){
	//Main page
	$routeProvider.when('/',{
		templateUrl:"summary.html",
		controller: "SummaryController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})	
	//New object for a particular site (i.e. Delicious or LJ)
	.when ("/site/new/:siteName",{
		templateUrl:  function(params){return "sites/"+ params.siteName + "/details.html";}  ,
		controller: "NewSiteDataController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//New object of a particular type (i.e. Input or Output)
	.when("/site/:itemType/new",{
		templateUrl: "newSite.html",
		controller: "NewSiteDataSelectionController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Existing object
	.when ("/site/:siteName/:id",{
		templateUrl:  function(params){return "sites/"+ params.siteName + "/details.html";}  ,
		controller: "EditSiteDataController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Specifying the Output for a new Post
	.when("/post/new",{
		templateUrl: "newPost.html",
		controller: "NewPostOutputSelectionController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Details for a new post
	.when("/post/new/:siteName/:outputId",{
		templateUrl: function(params){return "sites/"+params.siteName + "/post.html";},
		controller: "NewPostDataController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Details for a cloned post
	.when("/post/new/:siteName/from/:cloneId",{
		templateUrl: function(params){return "sites/"+params.siteName + "/post.html";},
		controller: "NewPostDataController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Details for an existing post
	.when("/post/:siteName/:postId",{
		templateUrl: function(params){return "sites/"+params.siteName + "/post.html";},
		controller: "ExistingPostDataController",
		resolve : {
			userDataLoaded : function(userData){
				return userData.loaded;
			}
		}
	})
	//Something has gone wrong
	.otherwise({
		template:"<H1>I am lost at {{location.path()}}</H1>",
		controller: "LostController"
			});
});
