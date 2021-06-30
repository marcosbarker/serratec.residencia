function tag(strings, ...values) {
  console.log(strings);
  console.log(values);
  console.log(strings[0]);
  console.log(values[0]);
  }
tag`Ola ${1}, bemvindo ao ${10+1} simposio!`