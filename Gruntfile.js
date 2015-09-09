module.exports = function(grunt) {
  grunt.initConfig({
	shell: {
	server: { /* Подзадача */
	    	command: 'java -cp L1.2-1.0-jar-with-dependencies.jar main.Main 8080'
	},
	},
  concat: {
	options: { 
		separator: ';' },
	
	foo: {
  /* Настройки цели foo */
  options: { /* ... */ },
  src: ['js/first.js', 'js/second.js'],
  dest: 'js/foo.js'
},

  	bar: { /* Цель bar */ }
	 },
  any_other_name: 'hello' /* Любое произвольное свойство */
});
//grunt.loadNpmTasks('grunt-contrib-concat');
grunt.loadNpmTasks('grunt-shell');
//grunt.registerTask('default', ['concat']);
grunt.registerTask('default', ['shell']);
};
