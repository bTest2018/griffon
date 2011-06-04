/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.gradle.api.file.FileCollection
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class GrailsDoc extends DefaultTask {
    @InputDirectory File srcDir
    @InputFiles File props
    @OutputDirectory File outputDir
	//@InputFiles File styleDir = 
	//@InputFiles File cssDir
	@InputFiles File imagesDir
	
    @TaskAction
    def publish() {
		ant.taskdef(name: 'docs', classname: 'grails.doc.ant.DocPublisherTask', 
			classpath: project.configurations.docs.asPath);
        ant.docs(src: srcDir.absolutePath,
                dest: outputDir.absolutePath,
                properties: props.absolutePath,
                //styleDir: styleDir,
                //cssDir: cssDir,
                imagesDir: imagesDir
        )
	}
}