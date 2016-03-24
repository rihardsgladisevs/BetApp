module.exports = function(grunt) {
    "use strict";

    require("matchdep").filterDev("grunt-*").forEach(grunt.loadNpmTasks);

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        mavenPrepare: {
            options: {
                resources: ['**']
            },
            prepare: {}
        },

        mavenDist: {
            options: {
                warName: '<%= mavenProperties.staticDirectory %>',
                deliverables: ['index.html', 'src/**'],
                gruntDistDir: 'dist'
            },
            dist: {}
        },

        mavenProperties: grunt.file.readJSON('maven-properties.json'),
        gruntMavenProperties: grunt.file.readJSON('grunt-maven.json'),

        clean: {
            build: {
                src: [
                    'dist'
                ]
            }
        },

        copy: {
            build: {
                files: [
                /**
                 * CSS Bootstrap
                 */
                    {
                        expand: true,
                        cwd: 'bower_components/bootstrap/dist/',
                        src: [
                            'fonts/*'
                        ],
                        dest: 'dist/themes/main/'
                    }
                ]
            }
        },

        less: {
            build: {
                options: {
                    paths: ['src/themes']//,
                    //compress: true
                },
                files: {
                    "dist/themes/main/css/main.css": "src/themes/main/less/main.less"
                }
            }
        },

        concat: {
            app: {
                files: {
                    'dist/js/app/app.min.js': [
                        'src/js/app/app.js'
                    ]
                }
            },
            lib: {
                files: {
                    'dist/js/lib/lib.min.js': [
                        'bower_components/jquery/dist/jquery.js',
                        'bower_components/bootstrap/dist/js/bootstrap.js',
                        'bower_components/stomp-websocket/lib/stomp.js',
                        'bower_components/sockjs-client/dist/sockjs.js'
                    ]
                }
            },
            css: {
                files: {
                    'dist/themes/main/css/lib.css': [
                        'bower_components/bootstrap/dist/css/bootstrap.min.css'
                    ]
                }
            }
        },

        uglify: {
            build: {
                options: {
                    mangle: false // prevent changes to your variable and function names
                },
                files: {
                    'dist/js/app/app.min.js': [
                        'src/js/app/app.js'
                    ],
                    'dist/js/lib/lib.min.js': [
                        'bower_components/jquery/dist/jquery.js',
                        'bower_components/bootstrap/dist/js/bootstrap.js',
                        'bower_components/stomp-websocket/lib/stomp.js',
                        'bower_components/sockjs-client/dist/sockjs.js'
                    ]
                }
            },
            stripComments: {
                options: {
                    compress: false,
                    mangle: false,
                    preserveComments: 'some'
                },
                files: {
                    'dist/js/lib/lib.min.js': 'dist/js/lib/lib.min.js'
                }
            }
        },

        hashres: {
            prod: {
                src: [
                    // WARNING: These files will be renamed!
                    'dist/themes/main/css/lib.css',
                    'dist/themes/main/css/main.css',
                    'dist/js/app/app.min.js',
                    'dist/js/lib/lib.min.js'
                ],
                // File that refers to above files and needs to be updated with the hashed name
                dest: [
                    'index.html'
                ]
            }
        },

        watch: {
            maven: {
                files: ['<%= gruntMavenProperties.filesToWatch %>'],
                tasks: 'mvn-dev'
            }
        }
    });

    grunt.registerTask('build',  [
        'clean',
        'copy',
        'concat:css',
        'less',
        'concat:app',
        'concat:lib'
    ]);

    // run on dev
    grunt.registerTask('mvn-dev', [
        'mavenPrepare',
        'build',
        'mavenDist'
    ]);

    // run on pre-test, uat & prod
    grunt.registerTask('mvn-prod', [
        'mavenPrepare',
        'build',
        'uglify:stripComments',
        'hashres:prod',
        'mavenDist'
    ]);

    grunt.registerTask('default', [
        'build'
    ]);
};