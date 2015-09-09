module.exports = function(grunt) {
  grunt.initConfig({
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
grunt.loadNpmTasks('grunt-contrib-concat');
grunt.registerTask('default', ['concat']);
};
