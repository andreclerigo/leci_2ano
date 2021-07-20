//
// João Manuel Rodrigues, AlgC, May 2020
// Joaquim Madeira, AlgC, May 2020
//
// A FileReader is an object that keeps a buffer of the last read data
// from a file, together with the file pointer and file name.
//

#include "FileReader.h"

#include <stdlib.h>

FileReader* FileReaderOpen(char* fname) {
  FileReader* fr = (FileReader*)malloc(sizeof(*fr));
  if (fr == NULL) abort();
  fr->name = fname;
  fr->bsize = (size_t)1;  // initial buffer: 1 char
  fr->buffer = (char*)malloc(fr->bsize);
  // DEBUG: fprintf(stderr, "FROpen name=%s, addr=%p, size=%zd\n", fr->name, fr->buffer, fr->bsize);
  if (fr->buffer == NULL) abort();
  fr->buffer[0] = '\0';   // fill with empty string
  fr->error = 0;
  fr->file = fopen(fname, "r");
  if (fr->file == NULL) {
    fr->error = errno;
    return NULL;
  }
  return fr;
}

void FileReaderClose(FileReader* fr) {
  if (fclose(fr->file) != 0) fr->error = errno;
  free(fr->buffer);
  free(fr);
}

// Advance file reader to the next line, which is stored in a new buffer.
// Return 1 on success, 0 on EOF or Error.
// NOTE: the client is responsible for freeing the allocated buffer.
int FileReaderNextLine(FileReader* fr) {
  // Read a line from file and store in allocated memory (see man getline)
  ssize_t read = getline(&(fr->buffer), &(fr->bsize), fr->file);
  // DEBUG: fprintf(stderr, "FRNextLine name=%s, addr=%p, size=%zd\n", fr->name, fr->buffer, fr->bsize);
  if (read < (ssize_t)0) {
    fr->error = errno;
    return 0;
  }
  return 1;
}

// Report the error number (errno) from last failed FileReader operation.
// 0 means No Error.
int FileReaderError(FileReader* fr) { return fr->error; }

// Return the pointer to the read buffer.
char* FileReaderBuffer(FileReader* fr) { return fr->buffer; }
