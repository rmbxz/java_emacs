(jdee-project-file-version "1.0")
(jdee-set-variables
'(jdee-jdk-registry (quote (("1.7" . "/usr/lib/jvm/java-7-openjdk-i386"))))
'(jdee-import-auto-sort t)
;; ant dir => /usr/share/ant/
;; ant, just type c-c c-v c-b or jdee-ant-build
'(jdee-ant-args "-emacs")  ;; view more information, -debug -d -emacs -verbose -v  -diagnostics (solve problem)  
'(jdee-ant-enable-find t)      ;; looking for build.xml
'(jdee-ant-read-args t)        ;; ant -emacs -verbose -v  -diagnostics (solve problem)
;;'(jdee-ant-home "/home/jdee_workspace/sourcePathx/sources/ant")
;;'(jdee-ant-use-global-classpath t)      ;; directly use  additional paths  instead of using path in build.xml 
'(jdee-build-function (quote jdee-ant-build))  ;; when press c-c c-v c-b run jdee-ant-build
'(jdee-ant-user-jar-files (quote ("/usr/share/java/ant-contrib-1.0b5-SNAPSHOT.jar")));; must install ant ant-contrib
;;
;;'(jdee-bug-jre-home "/usr/lib/jvm/java-7-openjdk-i386/jre")
'(jdee-checkstyle-classpath (quote ("~/.emacs.d/jars/checkstyle-all.jar")) t) ;;  override global-classpath , must be  classes for all sources 
'(jdee-checkstyle-style "~/.emacs.d/jars/checkstyle-all/sun_checks.xml" t)
'(jdee-compile-option-debug (quote ("all" (t t t))))
;;'(jdee-help-browser-function (quote browse-url-firefox)) ;; open doc by firefox
'(jdee-help-browser-function "w3m-browse-url")
'(jdee-server-dir "~/.emacs.d/jdee-server-master/target")
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
;; '(jdee-run-option-classpath "global")  ;;will not override  jdee-global-classpath, global means same as jdee-global-classpath
'(jdee-xref-cache-size 3)  ;; memory for 3 package at once cache memory 
'(jdee-xref-store-prefixes (quote     ("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z" "A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z" ))) ;; c-h v .must be done, then  jdee-xref-make-xref-db
'(jdee-xref-db-base-directory                    "/home/jdee_workspace/web8")      

'(jdee-compile-option-directory                  "/home/jdee_workspace/sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"  ) ;; must be one classes, this is for compiler C-c C-v C-c, not for flymake , the flymake destination is (jdee-ecj-command-line-args -d [here]
'(jdee-ecj-command-line-args  (quote ("-g" "-d"  "/home/jdee_workspace/sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"  "-source"   "1.7"  "-target"  "1.7"  "-warn:-serial"))) ;; this is for flymake , it is already contains -Xemacs  -noExit to hook ecj.jar  into flymake, see  /root/.emacs.d/elpa/jdee-20160728.1152/jdee-ecj-flymake.el 
;; all jars in the system here  /usr/share/java/
;; all jar in tomcat7 in lib /home/jdee_workspace/sourcePathx/servers/tomcat7/lib
;;
;; servlet-api, jsp-api,el api source code all in tomcat-source sourcecode
;; /home/jdee_workspace/sourcePathx/sources/servlet_jsp_src_from_tomcat7.zip
;;  wihtout .zip will search inside zip source files like this :- 
;;'(jdee-sourcepath (quote               ("./src"                                                          "../sourcePathx/sources/servlet-api-src"     "../sourcePathx/sources/struts1.3_org_src"         "../sourcePathx/sources/src_jdk_1.7" ))) ;; java only  for current  and  external packages will can use C-c C-v C-f to find inside files
'(jdee-sourcepath (quote               ("./src"                                                          "../sourcePathx/sources/servlet-api-src.zip"     "../sourcePathx/sources/struts1.3_org_src.zip"         "../sourcePathx/sources/src_jdk_1.7.zip" ))) ;; java only  for current  and  external packages 
'(jdee-compile-option-classpath (quote ("./src"                                                          "../sourcePathx/jars/servlet-api-3.0.jar"        "../sourcePathx/jars/myCollectedAllStruts1_3.jar"  ))) ;; java of current package, then  [[[classes ]]] of  external packages 
'(jdee-run-option-classpath (quote     ("../sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"   "../sourcePathx/jars/servlet-api-3.0.jar"        "../sourcePathx/jars/myCollectedAllStruts1_3.jar"  ))) ;; override global-classpath, must be  classes for all sources 
'(jdee-db-option-classpath (quote      ("../sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"   "../sourcePathx/jars/servlet-api-3.0.jar"        "../sourcePathx/jars/myCollectedAllStruts1_3.jar"  ))) ;; override global-classpath, classes for all sources , for jdee xref database
'(jdee-global-classpath    (quote      ("../sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"   "../sourcePathx/jars/servlet-api-3.0.jar"        "../sourcePathx/jars/myCollectedAllStruts1_3.jar"  ))) ;; classes for all sources 
'(jdee-built-class-path    (quote      ("../sourcePathx/servers/tomcat7/webapps/web8/WEB-INF/classes/"    ))) ;; used by xref  c-c c-v a/n , then  jdee-xref-make-xref-db
                                                                                                                                                                              
;;'(jdee-jdk-doc-url "file:///root/.emacs.d/jars/docs/api")
;; documentation , must be without / at the end 
;; c-c c-v c-w
;; ../sourcepathx/
'(jdee-help-docsets
    (quote
    (
     ("JDK 1.7 Javadoc" "file:///home/jdee_workspace/sourcePathx/doc/jdk-7u79-docs-all/api"         "1.7")
     ("serlvet 3  doc"    "file:///home/jdee_workspace/sourcePathx/doc/servlet-3_0-final-javadoc"   "1.7")
     ("struts 1.3 doc"    "file:///home/jdee_workspace/sourcePathx/doc/struts-1.3.10/docs/apidocs"  "1.7")
     )))

;;  no need for these url
;;     (nil "http://docs.oracle.com/javase/8/docs/api" "1.8")
;;     (nil "http://docs.oracle.com/javase/6/docs/api" "1.6")
;;     (nil "http://docs.oracle.com/j2se/1.5.0/docs/api" "1.5")


) ;; end of  (jdee-set-variables

;; 
;; old old default tomcat directories :- (tomcat seperated in many many directories, dont use it )
;; /var/lib/tomcat7
;; /usr/share/tomcat7/lib
;; /etc/tomcat7
;;
;; new new tomcat directory (cant find all apache server files in one place)
;; ../sourcePathx/servers/tomcat7/webapps/
;;
;;'(jdee-run-working-directory ".")
;; "/usr/lib/jvm/java-7-openjdk-i386/jre/lib/rt.jar"
;; /root/.emacs.d/jars/src_jdk_1.7.zip:/home/jdee_workspace/web8/bin:/home/jdee_workspace/web8/src:/usr/lib/jvm/java-7-openjdk-i386/jre/lib/rt.jar
;; '(jdee-sourcepath (quote ("./src/main/java" "./src/test/java" "$JAVA_HOME/src.zip")))
;; (setenv "ANT_HOME" "/usr/local/oss/apache-ant-1.9.6")
;; (setenv "JAVA_HOME"  "/usr/local/oss/jdk1.8.0_60")
;; (setenv "MAVEN_HOME" "/usr/local/oss/apache-maven-3.3.3")
;; (setenv "CLASSPATH"  "/root/.emacs.d/jars/src_jdk_1.7.zip:/home/jdee_workspace/web8/bin:/home/jdee_workspace/web8/src:/home/jdee/lib/rt.jar" ) 
;;
;; old old => service tomcat7 start
;;
;; new new => M-x tomcat-start
;; new new => M-x tomcat-stop
;; new new => M-x tomcat-clean
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 
;; confirm a1
;; confirm a2
;; done after confirm revert
;; "../sourcePathx/sources/servlet-api-src" will find inside all methods in  .zip  source files
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; magit git github
;; rmbxz
;; git@github.com:rmbxz/java_emacs.git   => for web8
;;
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; TAGS
;; jtags for TAGS file, to open source code with c-c j. visit methods 
;; add jdk_src and add current project files TAGS and struts servlet 
(setq tags-table-list '("/home/jdee_workspace/sourcePathx/sources/src_jdk_1.7"
               		    "/home/jdee_workspace/sourcePathx/sources/servlet-api-src"
        		    "/home/jdee_workspace/web8/src"
     			    ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
