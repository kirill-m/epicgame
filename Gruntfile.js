module.exports = function(grunt) {
  grunt.initConfig({
  concat: { /* Настройки задачи */ },
  any_other_name: 'hello' /* Любое произвольное свойство */
});
grunt.loadNpmTasks('grunt-contrib-concat');
grunt.registerTask('default', ['concat']);
};
